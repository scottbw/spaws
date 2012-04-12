# SPAWS - Sharing Paradata Across Widget Stores

SPAWS is a library for widget stores to support synchronising "paradata" including reviews, ratings, and download stats using the Learning Registry.

There is some more info here:

http://scottbw.wordpress.com/tag/oerri/

## How to use it
The main entry point to SPAWS is the ParadataManager class. Instances of this class can publish and retrieve paradata from a Learning Registry Node.

For example:

```java

node = new Node(myNodeUrl);

ISubmitter submitter = new Submitter();
submitter.setSubmitter("ME");
		
ParadataManager manager = new ParadataManager(submitter, node);
		
List<ISubmission> submissions = manager.getExternalRatingSubmissions("http://my.resource.name");

```

## Including the library in a project

Snapshots are available from the Sonatype snapshots repository; releases will eventually be available from maven central.