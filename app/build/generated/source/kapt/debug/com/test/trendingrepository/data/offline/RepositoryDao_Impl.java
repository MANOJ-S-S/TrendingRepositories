package com.test.trendingrepository.data.offline;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.test.trendingrepository.data.model.OfflineRepositoryDataItem;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RepositoryDao_Impl implements RepositoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OfflineRepositoryDataItem> __insertionAdapterOfOfflineRepositoryDataItem;

  private final SharedSQLiteStatement __preparedStmtOfNukeTable;

  public RepositoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOfflineRepositoryDataItem = new EntityInsertionAdapter<OfflineRepositoryDataItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `repository_table` (`id`,`author_name`,`repo_description`,`language`,`language_colour`,`repository_name`,`no_of_stars`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OfflineRepositoryDataItem value) {
        stmt.bindLong(1, value.getId());
        if (value.getAuthor() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthor());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLanguage());
        }
        if (value.getLanguageColor() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLanguageColor());
        }
        if (value.getName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getName());
        }
        stmt.bindLong(7, value.getStars());
      }
    };
    this.__preparedStmtOfNukeTable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM repository_table";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final OfflineRepositoryDataItem... repos) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOfflineRepositoryDataItem.insert(repos);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void nukeTable() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfNukeTable.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfNukeTable.release(_stmt);
    }
  }

  @Override
  public List<OfflineRepositoryDataItem> getAll() {
    final String _sql = "SELECT * FROM repository_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author_name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "repo_description");
      final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
      final int _cursorIndexOfLanguageColor = CursorUtil.getColumnIndexOrThrow(_cursor, "language_colour");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "repository_name");
      final int _cursorIndexOfStars = CursorUtil.getColumnIndexOrThrow(_cursor, "no_of_stars");
      final List<OfflineRepositoryDataItem> _result = new ArrayList<OfflineRepositoryDataItem>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OfflineRepositoryDataItem _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpAuthor;
        if (_cursor.isNull(_cursorIndexOfAuthor)) {
          _tmpAuthor = null;
        } else {
          _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
        }
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpLanguage;
        if (_cursor.isNull(_cursorIndexOfLanguage)) {
          _tmpLanguage = null;
        } else {
          _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
        }
        final String _tmpLanguageColor;
        if (_cursor.isNull(_cursorIndexOfLanguageColor)) {
          _tmpLanguageColor = null;
        } else {
          _tmpLanguageColor = _cursor.getString(_cursorIndexOfLanguageColor);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpStars;
        _tmpStars = _cursor.getInt(_cursorIndexOfStars);
        _item = new OfflineRepositoryDataItem(_tmpId,_tmpAuthor,_tmpDescription,_tmpLanguage,_tmpLanguageColor,_tmpName,_tmpStars);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
