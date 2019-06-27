package com.example.lenovo.day1.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.lenovo.day1.Been.BeenDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BEEN_DAO".
*/
public class BeenDaoDao extends AbstractDao<BeenDao, Long> {

    public static final String TABLENAME = "BEEN_DAO";

    /**
     * Properties of entity BeenDao.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property PublishTime = new Property(1, String.class, "publishTime", false, "PUBLISH_TIME");
        public final static Property NewsId = new Property(2, String.class, "newsId", false, "NEWS_ID");
        public final static Property NewsImg = new Property(3, String.class, "newsImg", false, "NEWS_IMG");
        public final static Property Source = new Property(4, String.class, "source", false, "SOURCE");
        public final static Property Category = new Property(5, String.class, "category", false, "CATEGORY");
        public final static Property Title = new Property(6, String.class, "title", false, "TITLE");
    }


    public BeenDaoDao(DaoConfig config) {
        super(config);
    }
    
    public BeenDaoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BEEN_DAO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PUBLISH_TIME\" TEXT," + // 1: publishTime
                "\"NEWS_ID\" TEXT," + // 2: newsId
                "\"NEWS_IMG\" TEXT," + // 3: newsImg
                "\"SOURCE\" TEXT," + // 4: source
                "\"CATEGORY\" TEXT," + // 5: category
                "\"TITLE\" TEXT);"); // 6: title
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BEEN_DAO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BeenDao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String publishTime = entity.getPublishTime();
        if (publishTime != null) {
            stmt.bindString(2, publishTime);
        }
 
        String newsId = entity.getNewsId();
        if (newsId != null) {
            stmt.bindString(3, newsId);
        }
 
        String newsImg = entity.getNewsImg();
        if (newsImg != null) {
            stmt.bindString(4, newsImg);
        }
 
        String source = entity.getSource();
        if (source != null) {
            stmt.bindString(5, source);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(6, category);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(7, title);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BeenDao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String publishTime = entity.getPublishTime();
        if (publishTime != null) {
            stmt.bindString(2, publishTime);
        }
 
        String newsId = entity.getNewsId();
        if (newsId != null) {
            stmt.bindString(3, newsId);
        }
 
        String newsImg = entity.getNewsImg();
        if (newsImg != null) {
            stmt.bindString(4, newsImg);
        }
 
        String source = entity.getSource();
        if (source != null) {
            stmt.bindString(5, source);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(6, category);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(7, title);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public BeenDao readEntity(Cursor cursor, int offset) {
        BeenDao entity = new BeenDao( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // publishTime
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // newsId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // newsImg
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // source
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // category
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // title
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BeenDao entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPublishTime(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setNewsId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNewsImg(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSource(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCategory(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTitle(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(BeenDao entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(BeenDao entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BeenDao entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}