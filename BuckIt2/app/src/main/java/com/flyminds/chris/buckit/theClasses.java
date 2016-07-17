package com.flyminds.chris.buckit;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.kinvey.java.model.KinveyMetaData;

/**
 * Created by Chris on 7/15/16.
 */
public class theClasses {

    static public class EventEntity extends GenericJson {
        @Key("_id")
        private String id;
        @Key("name")
        private String name;
        @Key
        private String location;
        @Key
        private String date;
        @Key("_kmd")
        private KinveyMetaData meta; // Kinvey metadata, OPTIONAL
        @Key("_acl")
        private KinveyMetaData.AccessControlList acl; //Kinvey access control, OPTIONAL
        public EventEntity(){}  //GenericJson classes must have a public empty constructor
    }




}
