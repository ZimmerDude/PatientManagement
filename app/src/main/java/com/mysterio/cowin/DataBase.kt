package com.mysterio.cowin
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.lang.Exception

val DATABASENAME="FINALLY"
val TABLENAME="patients"
val COLNAME="name"
val AGE="age"
val ID="id"
val EMAIL="email"
val PHONE="phone"
val GENDER="gender"
val COVID="covid"
val HOSPITAL="hospital"
val DISCHARGE="discharge"



open class DataBase(var context: Context) : SQLiteOpenHelper(context, DATABASENAME,null,1)
{
    override fun onCreate(db: SQLiteDatabase?) {
        try {


            val createTable = ("CREATE TABLE " + TABLENAME +" (" +
                    ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLNAME + " TEXT," + EMAIL +" TEXT," + PHONE + " TEXT," + GENDER + " TEXT," + COVID + " TEXT," + HOSPITAL + " TEXT," + DISCHARGE+" TEXT,"+
                    AGE +" TEXT"+")")

            db?.execSQL(createTable)}
        catch (e:Exception){
            print(e.stackTrace)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun insertdata(user: User)
    {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COLNAME,user.name)
        cv.put(AGE,user.age)
        cv.put(EMAIL,user.email)
        cv.put(PHONE,user.phone)
        cv.put(GENDER,user.gender)
        cv.put(COVID,user.covid)
        cv.put(HOSPITAL,user.hospital)
        cv.put(DISCHARGE,user.discharge)



        var result = db.insert(TABLENAME,null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
    }
    fun readData(i: Int): MutableList<User>{
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLENAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var user = User()
                user.id = result.getString(result.getColumnIndex(ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COLNAME))
                user.age = result.getString(result.getColumnIndex(AGE)).toInt()
                user.email = result.getString(result.getColumnIndex(EMAIL))
                user.phone = result.getString(result.getColumnIndex(PHONE))
                user.gender = result.getString(result.getColumnIndex(GENDER))
                user.covid = result.getString(result.getColumnIndex(COVID))
                user.hospital = result.getString(result.getColumnIndex(HOSPITAL))
                user.discharge = result.getString(result.getColumnIndex(DISCHARGE))
                list.add(user)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    open fun readDaataphone(phno: String) : MutableList<User>{
        var list : MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME where phone = $phno"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var user = User()
                user.id = result.getString(result.getColumnIndex(ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COLNAME))
                user.age = result.getString(result.getColumnIndex(AGE)).toInt()
                user.email = result.getString(result.getColumnIndex(EMAIL))
                user.phone = result.getString(result.getColumnIndex(PHONE))
                user.gender = result.getString(result.getColumnIndex(GENDER))
                user.covid = result.getString(result.getColumnIndex(COVID))
                user.hospital = result.getString(result.getColumnIndex(HOSPITAL))
                user.discharge = result.getString(result.getColumnIndex(DISCHARGE))


                list.add(user)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }



}