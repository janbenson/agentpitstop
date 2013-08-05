package com.jbsoft.library;
import static android.provider.BaseColumns._ID;
import static com.jbsoft.library.Constants.TABLE_NAME;
import static com.jbsoft.library.Constants.DATE_CREATED;
import static com.jbsoft.library.Constants.USERNAME;
import static com.jbsoft.library.Constants.PASSWORD;
import static com.jbsoft.library.Constants.URL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class apsdb  extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "agentpitstop.db" ;
	private static final int DATABASE_VERSION = 1;

	/** Create a helper object for the Events database */
	public apsdb(Context ctx) {
		super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
	db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + USERNAME
			+ " TEXT NOT NULL," + PASSWORD + " TEXT NOT NULL," + URL
			+ " TEXT NOT NULL," + DATE_CREATED + " TEXT NOT NULL);" );
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion,
	int newVersion) {
	db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	onCreate(db);
	}

}
