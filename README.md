# SPAWS - Sharing Paradata Across Widget Stores

SPAWS is a library for widget stores to support synchronising "paradata" including reviews, ratings, and download stats using the Learning Registry.

There is some more background information here:

http://scottbw.wordpress.com/tag/oerri/

## How to use it
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

For a more detailed example, see the [UserReviewService class in th Edukapp project](http://code.google.com/p/edukapp/source/browse/trunk/src/main/java/uk/ac/edukapp/service/UserReviewService.java).

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