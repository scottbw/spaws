# Rating

A rating record contains a rating from 0 to 5 but no other comments.

##Example:

    {
     "activity": {
        "actor": {
            "displayName": "John Smith",
            "url": "http://my-store.com/profiles/234"
        },
        
        "verb": {
            "action": "rated",
            "date": "2011-10-10",
            "measure": {
                "sampleSize": 1,
                "scaleMin": 0,
                "scaleMax": 5,
                "value": 5
            }
        },
        
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