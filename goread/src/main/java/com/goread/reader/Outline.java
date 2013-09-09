package com.goread.reader;

public class Outline {
    protected String Title;
    protected String Key;
    protected OutlineType Type;

    public Outline(String title, OutlineType type, String key) {
        Title = title;
        Type = type;
        Key = key;
    }

    public String Icon() {
        if (Type == OutlineType.FEED) {
            return MainActivity.getIcon(Key);
        }
        return ICON_FOLDER;
    }

    public static final String ICON_FOLDER = "__folder__";

    public int Unread() {
        switch (Type) {
            case ALL:
                return GoReadApplication.unread.All;
            case FOLDER:
                return GoReadApplication.unread.Folder(Key);
            case FEED:
                return GoReadApplication.unread.Feed(Key);
            default:
                return 0;
        }
    }

    public String getTitle() {
        String t = Title;
        int u = Unread();
        if (u > 0) {
            t = String.format("%s (%d)", t, u);
        }
        return t;
    }
}
