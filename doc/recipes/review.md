#Review

A review record contains a review comment and (optionally) a rating in the same format as for a rating record. The review comment is a String in the content of the activity.

##Example:

    {
     "activity": {
        "actor": {
            "displayName": "John Smith",
            "url": "http://my-store.com/profiles/234"
        },
        
        "verb": {
            "action": "reviewed",
            "date": "2011-10-10",
            "measure": {
                "sampleSize": 1,
                "scaleMin": 0,
                "scaleMax": 5,
                "value": 5
            }
        },
        
        "content": "I really like this game!",
        
        "object": {
            "id": "http://widgets.opera.com/bubbles"
        } 
     },
    
     "identity":{
        signer: "My Store",
        submitter: "My Store",
        submitter_type: "agent"
     }
    }