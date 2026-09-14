# Introduction

This is a Java client for Archive-It's API. It enables you to query seeds, collections, crawl jobs, WARC file metadata, account settings and many more. You can either use it with your own Archive-It credentials to gain access to your data, or without credentials to query public data.

# Usage

This is a Maven project, so you simply use it as a dependency in your project.

The main starting point is the `ArchiveitClient` class:

```java
ArchiveitClient client = new ArchiveitClient("myUsername", "myPassword");
```

Note that you do not need to provide credentials if you are only getting publicly available information from the API. In this case, just instantiate the client without a username and password:

```java
ArchiveitClient client = new ArchiveitClient();
```
  
## Features

The API functionalities of the client are divided into ''services''. Each service is responsible for a specific part of the API:

* `CollectionService`
* `SeedService`
* `AuthenticationService`
* `AccountService`
* `WarcService`
* `CrawlService`

Here is an example of getting the collection with ID `123` using the `CollectionService`:

````java
ArchiveitClient client = new ArchiveitClient("myUsername", "myPassword");
Collection collection = client.getCollectionService().getCollectionById(123);
System.out.println(collection.toString());
````

# Examples

Here we will give a few illustrative examples and use cases.

## Get all seeds within a collection

Assuming you know the ID if your collection, you can run:

````java
ArchiveitClient client = new ArchiveitClient("myUsername", "myPassword");
List<Seed> seeds = client.getSeedService().getSeedsByCollectionId(collectionId);
for (Seed seed : seeds)
{
	System.out.println(seed.toString());
}
System.out.println("Total: " + seeds.size()); 
````

## Get detailed information about a seed

Assuming you know the ID of your seed, you can run:

````java
ArchiveitClient client = new ArchiveitClient("myUsername", "myPassword");
Seed seed = client.getSeedService().getSeedById(seedId);
System.out.println(seed.toString());
````

## Get all collections within an Archive-IT account

Assuming you now the ID of your account, you can run:

````java
ArchiveitClient client = new ArchiveitClient("myUsername", "myPassword");
List<Collection> collections = client.getCollectionService().getCollectionsByAccountId(accountId);
for (Collection collection : collections)
{
	System.out.println(collection.toString());
}
System.out.println("Total: " + collections.size());
````

## Runnable example code

You can find executable code examples under `src/test/java`, in the `AppTest` class.


# License

[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

See `COPYING` to see full text.
