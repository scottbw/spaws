# Stats

A stats record contains a number of key statistics for a widget from a store. This is the total to date, not for a specific time period.

Current statistics include:

* downlaods: the number of times the widget has been downloaded or exported
* embeds: the number of times the widget has been embedded 
* likes: the number of times the widget has been added to favourites, flagged, or otherwise favourably singled out by users
* views: the number of times the widget detail page has been viewed

##Example:

    {
     "activity": {

        "verb": {
            "action": "stats",
            "date": "2011-10-10",
            "measure": {
                "downloads": 1,
                "embeds": 0,
                "likes": 5,
                "views": 211
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