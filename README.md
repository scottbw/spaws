# SPAWS - Sharing Paradata Across Widget Stores

SPAWS is a library for widget stores to support synchronising "paradata" including reviews, ratings, and download stats using the Learning Registry.

There is some more background information here:

http://scottbw.wordpress.com/tag/oerri/

## Quickstart: How to use it
The main entry point to SPAWS is the ParadataManager class. Instances of this class can publish and retrieve paradata from a Learning Registry Node.

For example:

```java

node = new Node(myNodeUrl);
ISubmitter submitter = new Submitter();
submitter.setSubmitter("ME");
ParadataManager manager = new ParadataManager(submitter, node);
		
List<ISubmission> submissions = manager.getExternalSubmissions("http://my.resource.name");

```

See the ParadataManager class for descriptions for all the methods available.

For a more detailed example, see the [UserReviewService class in the Edukapp project](http://code.google.com/p/edukapp/source/browse/trunk/src/main/java/uk/ac/edukapp/service/UserReviewService.java).

## Including the library in a project

Release artefacts are available from the Sonatype OSS repository for inclusion using Maven or Ivy. For Maven, you can use the following in your pom.xml:

    <dependency>
      <groupId>uk.ac.bolton</groupId>
      <artifactId>spaws</artifactId>
      <version>0.5</version>
    </dependency>

To include the Sonatype repository, add:

    <repository>
        <id>oss.sonatype.org</id>
        <url>https://oss.sonatype.org/content/repositories/releases</url>
    </repository>
    
Note that SPAWS relies on the LRJavaLib library jar being available; for more information see https://github.com/navnorth/LRJavaLib

## Creating a new ParadataManager instance

The ParadataManager is the class you use to access a Node and to handle all interactions.

A new ParadataManager is constructed with a _Submitter_ and a _Node_ as arguments. The _Submitter_ represents the system that is interacting with the node - your application. The _Node_ is the node you want to work with.

Example:

```java

Node node = new Node(new URL("http://alpha.mimas.ac.uk"), "me", "mynodepassword");
Submitter submitter = new Submitter();
submitter.setSubmitter("testo") // the submitter name
submitter.setSubmissionAttribution("testo"); // the attribution 
submitter.setSigner("testo"); // the signer
submitter.setSubmissionTOS("http://creativecommons.org/licenses/by/3.0/"); // the license

ParadataManager manager = new ParadataManager(submitter, node);

```
Note that you should use your site URL if possible as your submitter name so it doesn't clash with others.

## Finding submissions

The ParadataManager class has lots of methods for finding submissions. The most basic case is you want to find all submissions about a particular app that didn't originate from your system:

```java

List<ISubmission> submissions = manager.getExternalSubmissions("http://widgets.ac.uk/youtube");

```

You can also restrict this to submissions using a particular verb:

```java

List<ISubmission> submissions = manager.getExternalSubmissions("http://widgets.ac.uk/youtube","reviewed");

```

The ParadataManager class provides these as a convenience, however you can also use the classes in the _filters_ package to make your own specialized requests.

## Publishing submissions

The ParadataManager offers a batch method for sending a set of submissions. For example:

```java

List<ISubmission> submissions = new ArrayList<ISubmission>();
submissions.add(new Submission(new Actor("Bill"), new Rating(1), WIDGET_URI));
submissions.add(new Submission(new Actor("Amy"), new Rating(1), WIDGET_URI));
submissions.add(new Submission(new Actor("Chloe"), new Rating(1), WIDGET_URI));
submissions.add(new Submission(new Actor("Dave"), new Review("Great"), WIDGET_URI));
manager.publishSubmissions(submissions);

```