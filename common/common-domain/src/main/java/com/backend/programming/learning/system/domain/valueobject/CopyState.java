package com.backend.programming.learning.system.domain.valueobject;

public enum CopyState {
    CREATING,
    CREATED,
    UPDATING,
    UPDATED,
    DELETING,
    DELETED, //just to make sure there are enough state,this state is not needed most of the time
    CREATE_PROPAGATING,
    UPDATE_PROPAGATING,
    DELETE_PROPAGATING,
    CREATE_ROLLBACKING,
    UPDATE_ROLLBACKING,
    DELETE_ROLLBACKING,
    DELETE_FAILED,
    UPDATE_FAILED,
    CREATE_FAILED

}
