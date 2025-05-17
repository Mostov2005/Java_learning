package org.knit.solutions.Task20.passwordmanager.clipboard;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

@Component
public class SystemClipboardService implements ClipboardService {

    @Override
    public void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }
}