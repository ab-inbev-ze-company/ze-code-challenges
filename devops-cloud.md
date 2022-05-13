# DevOps / Cloud Challenge

## About the Challenge... 

This is all about scripting and the goal is to create a tool to retrieve information from AWS S3 buckets.

Feel free to ask any question - we really want you to succeed and then, join us to help evolve our platform.

## The Challenge - An AWS S3 storage analysis tool

This first one is entirely based on [Coveo DevOps Challenge](https://github.com/coveo/devops-coding-challenge), we just removed some requirements and made some things simpler in the end.

What you need to build, if you choose to take this challenge, is to develop an AWS S3 storage analysis tool. To test your tool, you might create a free [Amazon](http://aws.amazon.com/en/free/) account (if you don't already have one).

### Specifications

The tool is a shell command line utility that returns information over all [S3](https://aws.amazon.com/documentation/s3/) buckets in an Amazon account.

- Your tool must work on Linux, OSX and Windows.
- It must be easy to install and use.
- Ideally, your tool won't require installation of any other tools / libraries / frameworks to work.
- Time is money, we cannot afford running a tool that takes hours to complete, your solution should return results within seconds (or minutes if you are willing to test our patience :-).

#### The tool must return the following information

For each bucket:
- Name
- Creation date
- Number of files
- Total size of files in KB
- Last modified date of the most recent file
- And the most important of all, **how much does it cost**
  
#### The following options should be supported

- Filter buckets: support prefixes, glob and/or regexes in the bucket filter (e.g.: s3://mybucket/Folder/SubFolder/log*).
- Get additional buckets information (life cycle, cross-region replication, etc.) via explicit option

Some statistics to check the percentage of space used by a bucket, or any other good ideas you could have, are more than welcome.

### Rules

- Your are free to use the programming language and the [SDK](https://aws.amazon.com/tools/) of your choice, but remember that installation must not require us to install external tools in order to test the result of your work.
- We will test your work in our environment (which contains **several millions of files**). The overall performance of your tool will be evaluated. Most of the projects we receive take weeks to run in our environment, can you do better?

### General Guidance

- Feel free to add more features! Really, we're curious about what you can think of. We'd expect the same if you worked with us.
- Documentation and maintainability is a plus.
- Remember writing unit tests. 
- Think about security!

Should you have any questions or regards about the test, do not hesitate do ask us.

### How to deliver it

Please, use Github to host your code and add @ze-engineering-code-challenge as a collaborator for it. This Github account (@ze-engineering-code-challenge) is solely used by Zé's engineers to download your code and review it

**Once you have finished the challenge, please submit your information on this amazing form:**
  https://docs.google.com/forms/d/e/1FAIpQLSePVCWxsHZHoRqJY9-XFJHuL7iOjO00sfhZksLBmDbR0KuoLg/viewform