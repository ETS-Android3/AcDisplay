/*
 * Copyright (C) 2014 AChep@xda <artemchep@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package com.achep.base.ui.fragments.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.Html;

import com.achep.acdisplay.R;
import com.achep.base.ui.DialogBuilder;
import com.achep.base.utils.RawReader;

/**
 * Dialog fragment that shows FAQ.
 *
 * @author Artem Chepurnoy
 */
public class HelpDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String source = RawReader.readText(getActivity(), R.raw.faq);
        CharSequence message = Html.fromHtml(source);
        return new DialogBuilder(getActivity())
                .setIcon(R.drawable.ic_action_help_white)
                .setTitle(R.string.help_dialog_title)
                .setMessage(message)
                .createAlertDialogBuilder()
                .setNegativeButton(R.string.close, null)
                .create();
    }

}