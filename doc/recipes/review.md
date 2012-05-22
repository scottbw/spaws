#Review

A review record contains a review comment. The review comment is a String in the content of the activity.

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
            "context":{
                "objectType": "widget",
                "id": "http://my-store.com/widgets/8",
                "description": "Detail page"
            },
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