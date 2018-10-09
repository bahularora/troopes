package com.troopes.android.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomDialog extends AppCompatDialog {

    private CustomDialog(Builder builder) {
        super(builder.context);

        final Dialog dialog = new Dialog(builder.context);

        if (builder.dialogLayoutId != -1) {
            buildFromLayoutId(builder, dialog);
        } else {
            buildWithContent(builder, dialog);
        }
        dialog.setCancelable(builder.cancelable);
        if (builder.cancelable == true) {

        }
        //dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        dialog.show();

        if (builder.isAutoDismiss) {
            handleDialogAutoDismiss(builder, dialog);
        }

    }

    private void handleDialogAutoDismiss(Builder builder, final Dialog dialog) {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {

            public void run() {
                if (dialog != null && dialog.isShowing()) dialog.dismiss();
            }
        };
        // do this in onDestroy - mHandler.removeCallbacks(mRunnable);
        handler.postDelayed(runnable, builder.dismissDuration);
    }

    private void buildWithContent(Builder builder, Dialog dialog) {
        LinearLayout layout = new LinearLayout(builder.context);
        layout.setOrientation(LinearLayout.VERTICAL);
        if (builder.title != null) {
            TextView title = new TextView(builder.context);
            title.setText(builder.title);
            title.setGravity(View.TEXT_ALIGNMENT_CENTER);
            layout.addView(title);
        }
        if (builder.message != null) {
            TextView message = new TextView(builder.context);
            message.setText(builder.message);
            message.setGravity(View.TEXT_ALIGNMENT_CENTER);
            layout.addView(message);
        }
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(400, 300);
        dialog.addContentView(layout, llp);
    }

    private void buildFromLayoutId(final Builder builder, Dialog dialog) {
        dialog.setContentView(builder.dialogLayoutId);
        if (builder.title != null) {
            TextView title = dialog.findViewById(builder.getTitleViewId());
            title.setText(builder.title);
        }
        if (builder.message != null) {
            TextView message = dialog.findViewById(builder.getMessageViewId());
            message.setText(builder.message);
        }
        // TODO: how to use it when we create dialog
        if (builder.getPositiveButtonId() != -1) {
            Button button = dialog.findViewById(builder.getPositiveButtonId());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (builder.onPositiveActionListener != null) {
                        builder.onPositiveActionListener.onAction(view);
                    }
                }
            });
            if (builder.positiveButtonText != null)
                button.setText(builder.positiveButtonText);
            // set it to do something on onClick
        }
        if (builder.getNegativeButtonId() != -1) {
            Button button = dialog.findViewById(builder.getNegativeButtonId());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (builder.onNegativeActionListener != null) {
                        builder.onNegativeActionListener.onAction(view);
                    }
                }
            });
            if (builder.negativeButtonText != null)
                button.setText(builder.negativeButtonText);
        }
        if (builder.getOkButtonId() != -1) {
            Button button = dialog.findViewById(builder.getOkButtonId());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (builder.onOKActionListener != null) {
                        builder.onOKActionListener.onAction(view);
                    }
                }
            });
            if (builder.oKButtonText != null)
                button.setText(builder.oKButtonText);
        }
        if (builder.getViewButtonId() != -1) {
            View button = dialog.findViewById(builder.getViewButtonId());
            if (Builder.VIEW_BUTTON_ACTION.OK == builder.viewButtonAction) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (builder.onOKActionListener != null) {
                            builder.onOKActionListener.onAction(view);
                        }
                    }
                });
            } else if (Builder.VIEW_BUTTON_ACTION.CLOSE == builder.viewButtonAction) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (builder.onNegativeActionListener != null) {
                            builder.onNegativeActionListener.onAction(view);
                        }
                    }
                });
            }

            // set it to do something on onClick
        }
    }


    public interface OnOKActionListener {
        void onAction(View view);
    }

    public interface OnPositiveActionListener {
        void onAction(View view);
    }

    public interface OnNegativeActionListener {
        void onAction(View view);
    }

    public static class Builder {
        private Context context;

        private OnOKActionListener onOKActionListener;
        private OnPositiveActionListener onPositiveActionListener;
        private OnNegativeActionListener onNegativeActionListener;

        // use this alone only when using default implementation
        private String message = null;
        private String title = null;
        private Drawable messageIcon = null;

        // will be using when we add using setView
        private int titleId = -1;
        private int messageId = -1;
        private int positiveButtonId = -1;
        private String positiveButtonText = null;
        private int negativeButtonId = -1;
        private String negativeButtonText = null;
        private int okButtonId = -1;
        private String oKButtonText = null;
        private int viewButtonId = -1;
        private VIEW_BUTTON_ACTION viewButtonAction;
        private int dialogLayoutId = -1;

        /**
         * set of variable specifying on how to remove dialog from view
         */
        private boolean cancelable = true;
        // useful for feedback response
        private boolean isAutoDismiss = false;
        // in millis second
        private int dismissDuration = 2000;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setIcon(Drawable messageIcon) {
            this.messageIcon = messageIcon;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        // todo
        public Builder setAutoDismiss(boolean isAutoDismiss) {
            this.isAutoDismiss = isAutoDismiss;
            return this;
        }

        public Builder setDismissDuration(int dismissDuration) {
            this.dismissDuration = dismissDuration;
            return this;
        }

        public Builder setDialog(@LayoutRes int dialogLayoutId) {
            this.dialogLayoutId = dialogLayoutId;
            return this;
        }

        int getTitleViewId() {
            return this.titleId;
        }

        public Builder setTitleViewId(@IdRes int titleId) {
            this.titleId = titleId;
            return this;
        }

        int getMessageViewId() {
            return this.messageId;
        }

        public Builder setMessageViewId(@IdRes int messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setPositiveButtonText(String positiveButtonText) {
            this.positiveButtonText = positiveButtonText;
            return this;
        }

        int getPositiveButtonId() {
            return this.positiveButtonId;
        }

        public Builder setPositiveButtonId(@IdRes int positiveButtonId) {
            this.positiveButtonId = positiveButtonId;
            return this;
        }

        public Builder setNegativeButtonText(String negativeButtonText) {
            this.negativeButtonText = negativeButtonText;
            return this;
        }

        int getNegativeButtonId() {
            return this.negativeButtonId;
        }

        public Builder setNegativeButtonId(@IdRes int negativeButtonId) {
            this.negativeButtonId = negativeButtonId;
            return this;
        }

        public Builder setOKButtonId(@IdRes int okButtonId) {
            this.okButtonId = okButtonId;
            return this;
        }

        public Builder setOKButtonText(String okButtonText) {
            this.oKButtonText = okButtonText;
            return this;
        }

        int getOkButtonId() {
            return this.okButtonId;
        }

        public Builder setViewButtonAction(VIEW_BUTTON_ACTION viewButtonAction) {
            this.viewButtonAction = viewButtonAction;
            return this;
        }

        int getViewButtonId() {
            return this.viewButtonId;
        }

        public Builder setViewButtonId(@IdRes int viewButtonId) {
            this.viewButtonId = viewButtonId;
            return this;
        }

        public Builder setOnOKActionListener(OnOKActionListener onOKActionListener) {
            this.onOKActionListener = onOKActionListener;
            return this;
        }

        public Builder setOnNegativeActionListener(OnNegativeActionListener onNegativeActionListener) {
            this.onNegativeActionListener = onNegativeActionListener;
            return this;
        }

        public Builder setOnPositiveActionListener(OnPositiveActionListener onPositiveActionListener) {
            this.onPositiveActionListener = onPositiveActionListener;
            return this;
        }

        public enum VIEW_BUTTON_ACTION {
            OK, CANCEL, CLOSE, NONE
        }

        public CustomDialog build() {
            return new CustomDialog(this);
        }
    }
}
