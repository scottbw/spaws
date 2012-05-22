# Ratings

A ratings record contains an aggregate set of ratings for a widget. This is always assumed to be the total to date for the widget from the source store.

The rating comprises a sample size and value; the value should be the mean rating from the sample.

Note as ratings are composite, there is no actor component.

## Example:

    {
     "activity": {    
        "verb": {
            "action": "allrated",
            "measure": {
                "sampleSize": 37,
                "scaleMin": 0,
                "scaleMax": 5,
                "value": 22.5
            },
            "context":{
                "objectType": "widget",
                "id": "http://my-store.com/widgets/8",
                "description": "Detail page"
            },
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