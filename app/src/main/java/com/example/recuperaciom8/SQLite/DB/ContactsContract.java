package com.example.recuperaciom8.SQLite.DB;

import android.provider.BaseColumns;

public class ContactsContract {
    private ContactsContract(){}
    public static class ContactsEntry implements BaseColumns {
        public static final String TABLE_NAME ="Ubicacio";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "ciutat";
        public static final String COLUMN_NAME_TITLE2 = "temps";
        public static final String COLUMN_NAME_TITLE3 = "temperatura";

    }
}

