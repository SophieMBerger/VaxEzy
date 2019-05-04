package com.vaxezy.johnlee.vaxezy;

import java.util.ArrayList;
import java.util.List;

public class RecordBase
{
    static RecordBase innerRecord;

    public static RecordBase GetRecordBase(){
        if(innerRecord == null)
            innerRecord = new RecordBase();
        return innerRecord;
    }


    private RecordBase(){}

    public List<Record> records =  new ArrayList<Record>();
}
