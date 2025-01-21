## AWS Orientation

### Introduction
Amazon Web Services (AWS) is one of several major cloud services providers, perhaps the biggest in terms of market share. AWS is a cloud computing platform that provides a wide range of infrastructure services such as computing power, storage, and databases, as well as application services, deployment, and management tools, all of which can be easily scaled up or down to meet changing demands. It is a flexible, cost-effective, and reliable solution that enables individuals and businesses to run applications and services in the cloud, with pay-as-you-go pricing and no upfront costs. There are six key advantages provided by the cloud:
1. Trade capital expense for variable expense.
    - instead of needing to guess at your traffic and processing needs you can use a flexible service that scales with your needs, both for the increase and decrease in traffic and processing power need.
2. Benefit from massive economies of scale.
    - because user actions are all aggregated in the cloud (read: it is all localized in the cloud and handled by the web service) you can benefit from a pay-as-you-go model that many web services providers like AWS use.
3. Stop guessing about capacity.
    - similar to the first bullet point, there is no need to guess at how much hardware and processing power you need: because of the flexibility of autoscaling you can avoid sitting on idle hardware or being unable to handle all the requests to your product
4. Increase speed and agility.
    - when you host your service locally you have to manually upgrade everything, which can take anywhere from hours to days. With cloud computing you have access to advanced hardware immediately.
5. Eliminate overhead cost of maintaining data centers
    - providers like AWS handle the maintenance of data centers, which means you don't need to budget for the servers, properties, maintenance crew, security, etc.
6. Go global in minutes.
    - because most services like AWS have global coverage you can choose what regions you want to deploy your app in and reduce latency and increase accessibility of your product with a few mouse clicks

There are three models of Cloud Computing:
- Infrastructure as a Service (IaaS):
    - a self-service model for managing remote data center infrastructures. AWS offers IaaS in the form of data centers. Essentially, this means that AWS itself is the IaaS
- Platform as a Service (PaaS):
    - allows organizations to build, run and manage applications without the IT infrastructure. AWS RDS is a PaaS: it provides a means of managing your product (storing the data related to it) without providing any infrastructure to manage it (need dbeaver or another program to interface with the database)
- Software as a Service (SaaS):
    -  replaces the traditional on-device software with software that is licensed on a subscription basis. It is centrally hosted in the cloud. A good example is Salesforce
![cloud service model](CloudServiceModel.png)

#### Free Tier
There are a number of services which are "Free Tier eligible", meaning that the service can be free provided you adhere to the constraints. Free Tier is generally for you to learn about and test services. EC2, RDS, and S3 are all Free Tier for limited use. Free Tier is somewhat convoluted, and many services are tightly intertwined. Always be extremely careful when allocating AWS resources: If you are attempting to make use of Free Tier services check out the Free Tier offerings [here](https://aws.amazon.com/free/)

### Regions & Availability Zones
A **Region** is a geographic area served by AWS data centers. Regions are isolated from one another, and resources do not automatically replicate across regions. AWS spans 27 regions at the time of this writing, with data centers across the globe. An AWS Region is a geographical location with a collection of **Availability Zones** (AZ) mapped to physical data centers in that region. Every region is physically isolated from and independent of every other region in terms of location, power, water supply, etc. This level of isolation is critical for workloads with compliance and data sovereignty requirements where guarantees must be made that user data does not leave a particular geographic region. The presence of AWS regions worldwide is also important for workloads that are latency-sensitive and need to be located near users in a particular geographic area.

An **Availability Zone** (AZ) is a "highly available" logical data center within a region. Each AZ in a region has its own redundant power, networking, and connectivity to reduce the likelihood of multiple zones failing at once. While regions are separate, AZs are connected together to provide rapid fault tolerance and replication. If an AZ should fail, its workload will be redistributed to other AZs in the region

AWS has a few newer options for managing deployments as well:
- **Local Zones** are extensions of geographic regions, offering proximity to your users and ultra-low latency
- **Wavelength Zones** are designed to provide ultra-low latency to mobile users by placing the zone right at the edge of a telecommunication carriers' 5G network
- **AWS Outposts** allow you to extend AWS infrastructure into your own premises. By providing local access to AWS managed infrastructure, AWS Outposts enables customers to build and run applications on premises using the same programming interfaces as in AWS Regions, while using local compute and storage resources for lower latency and local data processing needs

### Common Services
We will be looking at several of the most foundational services offered by AWS. These are the services you are most likely to use while learning and practicing development concepts. EC2, RDS, and S3 will all be covered in greater detail in their own modules

**EC2**: The **Elastic Cloud Compute** service offers virtual machines, computers that function like any other by emulating physical components. Somewhere in AWS data centers there are powerful physical machines on which many EC2 virtual machines could potentially be running. EC2 machines can come in many sizes which represent overall computing power. Processors, storage, networking, operating system, and more can be customized to fit your needs. Pricing is based on use, so you aren't paying for idle resources

**RDS**: The **Relational Database Service** offers database hosting. An RDS instance is just an EC2 server specially set up to run a Relational Database Management Engine (RDBMS). This engine serves up your database for querying

**S3**: The **Simple Storage Service** offers object storage in the cloud. Instances of S3 are called "Buckets" and they can be configured for a variety of uses including site hosting and block storage. Note that an "object" is just about anything digital: if it is a type of file you can probably store it in an S3 bucket

**CodeBuild & CodePipeline**: CodeBuild and CodePipeline are CICD services. CodeBuild offers build servers which will build (compile, link, lint, etc.) your project. CodeBuild is often used as part of a larger CodePipeline, which manages the process of building, delivering, and deploying projects

**Elastic Beanstalk & Elastic Container Service**: Elastic Beanstalk offers web environments, scalable clusters of machines on which to deploy your web applications. An EB environment might include EC2 instances for servers, S3 buckets for storage, **CloudFormation** for scaling and orchestration, and **CloudWatch** for health monitoring. Similar to that is Elastic Container Service: a fully managed container orchestration service. This service is particularly useful if you need multiple containers to be networked together due to ECS managing the underlying infrastructure for you

The services listed are a fraction of the offerings AWS provides

## AWS RDS
RDS is a collection of services for operating a relational database server in the cloud. Take note of the three distinct things that we often call "databases":

- Database Server: A server like any other which hosts the engine
- Database Engine: The software that allows manipulation of the database
- Database: one or more files that store data in a systematic way

Amazon RDS helps us manage the Database Server and related infrastructure. We can choose our Database Engine (or management system) from one of the many implementations of SQL including: MySQL, PostgreSQL, MariaDB, and Microsoft SQL Server. Amazon even has its own implementation called Aurora.

An RDS instance is little more than an EC2 instance that has the RDBMS, or the Database Engine, installed and configured out-of-the-box. Your RDS instance can scale vertically, and can be set up to scale horizontally as well, though these features aren't covered by free tier. May features of the service can be handled by AWS (updates to the RDBMS, automated backups, data encryption) but not all of these offerings are strictly free tier. For instance, by default, AWS assumes you want your instance to auto scale storage up to 1000G, which is a value not covered by free tier. You as the developer have to turn off the feature

## AWS S3

### S3 Introduction
S3 is an object storage service that offers secure and scalable object storage in the cloud. S3 storage is broken into buckets, containers where your data can be found. These buckets can be configured independently and have no limits on how much data can be stored.

### S3 Bucket Configuration

#### Object Storage
Object storage refers to the way the data is organized, into objects rather than blocks or files. In practice, object storage is very similar to file storage, and both would be implemented physically as block storage. This layer of abstraction is why there is no limit on the data in a bucket, there is no finite volume to fill up. If you were to explore a bucket with data, you would find it to be very similar to any file system you are familiar with.

#### Storage Classes
There are a number of different storage classes, which control the way our data is stored and retrieved under-the-hood. Sometimes we need storage that is always fast, other times we might want to store data that is rarely retrieved and doesn't need to be instantly available:
- Standard - General purpose
- Intelligent-Tiering - automatically re-categorizes objects into appropriate tier based on usage
- Standard Infrequent Access - For data that is not accessed frequently
- One Zone Infrequent Access - Cheaper but only exists in one AZ
- Glacier Instant Retrieval - Archive storage for rarely accessed data
- Glacier Flexible Retrieval - Archive storage, asynchronous retrieval
- Glacier Deep Archive - Cheapest solution, for long term storage

### Hosting Static Sites
A web site is retrieved with an HTTP GET request to a URL, and the web server responds with the HTML, CSS, and JavaScript content that makes up the site. S3 buckets are already designed to serve data objects via HTTP and configuring them to host a site is as simple as one click. This will give you a public URL and have the S3 bucket respond to GET requests to that URL with your site as though it were a web server (which it basically is)

### S3 Access Policies
S3 Buckets have two main ways of controlling access to their resources: Access Control Lists (ACLs) and Bucket Policies (AWS recommended). ACLs are simpler to implement, but require more manual user input, whereas policies can be confusing to understand, but when implemented correctly make it easier to create batch access rules in the bucket. If ACLS are enabled in a bucket (determined when first created) then every object added to the bucket requires you to determine what level of access different users of the bucket have (owner can almost always read and update by default). Non-owners (determined again by your bucket settings) must be given permission to read and update the objects in the bucket. There are three options for determining ownership
- Bucket Owner enforced (default, and recommended)
    - in this mode ACLs are disabled and permissions must be determined via policies. All objects are owned by the creator of the bucket
- Bucket Owner preferred
    - not common, bucket creator is given control of the object if the ACL "bucket-owner-full-control" is selected
- Object Writer
    - the account that uploads the object is considered the owner, and grants other users access via ACL

## AWS EC2

### EC2 Introduction
Amazon's Elastic Compute Cloud (EC2) is a web service that provides secure, re-sizable compute capacity in the cloud. It is designed to make web-scale cloud computing easier for developers. EC2s offer the following:
- Virtual Computing Environments (images)
    - pre-configured templates for your images known as Amazon Machine Images (AMIs). These include the OS and additional software you need
- Various instance types. These have differing CPUs, memory, storage, and networking capacity
    - an instance is a virtual server in the cloud
- secure login information for your instance
    - Amazon holds a public key, you keep a private key
    - security groups that determine who can access your instance via protocols, ports, and IP ranges
- Complete Control
    - As the creator of the instance you have root access to each of your instances, and you can start and stop them without losing access to the data they hold.
- Flexible Cloud Hosting Services
    - You can mix and match operating systems, cpu, memory, etc with your instances, creating exactly what you need to manage and run your web product.
- Elasticity
    - The "Elasticity" of EC2s is their ability to auto scale both up and down: when your system has higher demand the instance can add more processing power to handle the load, and when the traffic dies down it can revert to a lower processing power, saving you money in the long run.
    
### Security Groups
A Security Group controls incoming and outgoing traffic to and from one or more resources (like an EC2 instance). A VPC, or Virtual Private Cloud, is a logical grouping of AWS resources into a virtual network. A Security Group can only be applied to resources which exist inside its VPC.

Security Groups control traffic with rules. Rules make determinations about what traffic is allowed based on the following parameters:
- Protocol
- Port
- ICMP Type (Internet Control Message Protocol)
- Source or Destination

### SSH into EC2
EC2 instances can be opened up to be public facing and will be assigned a public address on the internet which can be used to access it remotely. SSH, or Secure Shell, is a network protocol that gives users a secure way to access a computer over an unsecured network. SSH is built atop the TCP protocol, and port 22 is commonly reserved for SSH traffic.

Access via the web console:
- On your AWS Management Console, navigate to EC2 > Instances
- Click on the instance you wish to access
- Click Connect at the top of the Instance Summary
- Click the orange Connect button
- This should open the web console and initiate an SSH connection to the server.

Access via local terminal: **NOTE** You will need a public/private key pair to access the server. This key should have been generated during the EC2 initialization process. If not, you can generate one and assign it to your instance
- On your AWS Management Console, navigate to EC2 > Instances
- Click on the instance you wish to access
- Click Connect at the top of the Instance Summary
- Select the SSH Client tab
- Instructions are given here, with an example console command. You will need to make sure you adjust the command to accurately reference the key file. You may need to adjust the file security settings on the key file, depending on the OS you are working with locally

### AMI
An image in this context refers to a binary snapshot of the state of a machine at a given moment. This image can be used to re-create that exact state. Generally, this is used to load software onto a system without having to install each item individually. When it comes to virtual machines, installing an OS and a bunch of software would be far too time consuming. So, instead, VMs launch with an image of a working machine and are ready almost immediately. Amazon Machine Images (AMIs) are images maintained and supported by AWS to be used to launch EC2 instances. They come in the form of ready-to-go operating systems with pre-installed software and pre-configured settings. There are AMIs for nearly any OS you can imagine, including many versions of Windows, MacOS, and Linux distributions. Amazon Linux 2 is a very common AMI, based on Amazon's own Linux distribution. It is optimized to work in the EC2 environment, and comes loaded with a minimal set of software packages to integrate with AWS services and act as a high-performance execution environment

### EBS (Elastic Block Storage)
Amazon EBS offers block storage volumes for EC2 instances. Block storage is the technology that nearly all file systems are built on top of. These can be attached to an EC2 instance where they act like any storage volume, but persist beyond the life of the instance. EBS volumes can be dynamically resized and reconfigured even while attached to an instance. EBS volumes are frequently used as the primary storage volume in EC2 instances where they can emulate both solid-state and hard drives. You can back up the data on your Amazon EBS volumes to Amazon S3 by taking point-in-time snapshots. Snapshots are incremental backups, which means that only the blocks on the device that have changed after your most recent snapshot are saved.

Another feature of EBS is volume encryption: this allows you to encrypt any data not currently being utilized by an EC2 instance, which makes for secure data storage and travel, should you need to change the location of a snapshot

### AutoScaling
Amazon EC2 Auto Scaling helps you ensure that you have the correct number of Amazon EC2 instances available to handle the load for your application. You can create collections of EC2 instances, called Auto Scaling groups. These groups can maintain a minimum and maximum number of instances and can be scaled manually or automatically to meet demand. There are two types of scaling in EC2:
- Vertical Scaling
- Horizontal Scaling

Vertical scaling refers to changing the performance of a single instance up and down. Adding or removing virtual resources like CPUs, and RAM are examples of vertical scaling. Horizontal scaling refers to changing the number of instances. Additional instances are added as needed to meet demand. As demand drops, instances are removed, and their load is balanced between those that remain. Vertical scaling generally works up to a point, but once we are dealing with very large amounts of traffic horizontal scaling becomes more useful to meet demand.

## IAM
When a large company needs a large collection of cloud resources with varying levels of access and permissions to use those resources, just sharing admin credentials is not a good long term solution. Instead, companies can make use of the Identity and Access Management (IAM) service to provide specific permissions and access to users in the company. This is done through managing groups, users, and their associated policies

### IAM Groups
Often there will be multiple departments that require similar access to cloud resources, though their intended uses with those resources will vary. You can simplify cloud permissions by creating an IAM group with shared permissions settings and then assign your various teams that need the shared permissions to the group. This will make any users you add the group share the same policies and permissions to interact with cloud resources (think permission to view EC2 instance data, but not to create new instances).

### IAM User
IAM User credentials are how you provide limited access to cloud resources to your team when working with AWS cloud resources. Each user can be provided IAM user credentials that will allow them to interact with whatever cloud resources you have assigned permissions to (viewing/creating EC2 instances, uploading/downloading data from an S3 bucket, etc). For common permissions you assign Users to their appropriate groups, but for individual permissions (think admin permissions or one-off needs) Users can have their own unique permissions assigned to them, outside of whatever Groups they are associated with

### IAM Policies
Policies are how you determine what members of a group or individual users can do with your AWS resources. Companies can use these policies to control what team members with access to the cloud can do with the cloud resources. For instance, your IT team may have a Group created for them that gives them permission to create, delete, start, and stop EC2 instances, while the dev team has a group policy that allows them to view EC2 instance information, but no power to alter the state of the instance (they don't need to control the instance, just use it)

## DevOps

### DevOps Introduction
Software Development and Operations (DevOps) is a methodology that combines the development, deployment, and maintanece of code into a single, streamlined process. Ideally, this process is automated as much as possible. There are 5 general steps to Devops:
1. Source code Control: Producing (writing) code and pushing to a repository
    - you should already be familiar with this step, it is just the creation of your code (following TDD and utilizing BDD) and publishing it to a central repository
2. Building and Testing Automation: Test basic functionality of code (Generally unit testing) and create a new, working build
    - you should be testing your code as you develope, but this is the final, overarching test. This round of testing is the one you want to generate documentation and reports from for either your client or other developers to see
3. Deploying to Staging: Deployment of working build to a temporary environment
    - This is a pre-configured enviornment where you can test the entirety of your application without affecting your production enviornment
4. Acceptance Testing: Undergo other more complex tests (systems, integration) within temporary environment
    - think of this as the final, official BDD test. This is where the entirety of the (supposedly) working application is put to the test. Again, it is from this test you will want to save your generated report and have it available to either the client or other developers
5. Deployment of Build: Migrate working build to Production environment accessible by end users
    - this is the actual deployment of your product

If you are developing with an Agile Mindset there are three practices to know that assist in the process of creating a smooth DevOps pipeline
- Continuous Integration
    - This is the practice of regularly and consistently merging code into a central repository. It also involves reviewing the code to make sure the integration is as smooth as possible
- Continuous Delivery
    - This is the pratice of automating the DevOps pipeline as much as you can. This means once your code is merged into the central repository it is downloaded and built/tested in a staging environment. This means steps 1-3 of the DevOps process should be automated, and step 4 should be too if you can manage it, though this is not always possible. Deploying to the production environment (step 5) should be done manually, since step 4 may reveal bugs you need to fix before deployment to production
- Continuous Deployment
    - Continuous Deployment is the process by which the entirety of the DevOps pipeline is automated, including deployment to production. You can think of it as the all encompassing Agile practice of DevOps, with each other practice being a subset of it

### Continuous Integration
Continuous Integration (CI) is the most fundamental step in creating an autonomous development pipeline. CI is achieved by the practice of consistently merging code into a central repository. More importantly, CI benefits greatly from the inclusion of rigorous testing as part of your CI process. Particularly important are unit and integration testing

DevOps is about automating and streamlining the parts of software development that get the developers feedback. CI married with testing is the first step to fully realizing an autonomous development pipeline. Each time a developer completes some amount of work and merges that work with the repository, each unit of that new code is tested, and then that new code is integrated and tested with the rest of the code. If testing is done well, this should provide rapid feedback about defects as each module develops. Continuous Integration establishes the foundation for an automated DevOps pipeline because it provides the following benefits:
 - Ensures the entire team works on the most up to date code
    - Frequently pushing code allows developers to account for changes performed by other team members quickly.
 - Detects broken builds quickly
   - If problems arise, version control software can help detect the root cause or rollback changes when necessary
 - Code can be tested easily by creating separate test or development branches based on the main code
 - Reduces risk in development when a large codebase has already been established
 - Reduces the overall amount of defects in a project

### Continuous Delivery
Continuous Delivery is a paradigm in which the building, management and testing of produced software is automated such that deployments can be performed at the push of a button. Continuous Delivery seeks to automate every possible step up to but not including deployment. It depends on CI and is a stepping stone on the way to Continuous Deployment (a fully automated development pipeline). Since we don't include deploying the product we can still preform final user testing, and/or leave the production deployment to a regular schedule.

![cd1](cd1.png)

### Continuous Deployment
Continuous Deployment (CD) advances continuous delivery by also automating the deployment of software to production environments. CD refers to the entire automated development pipeline including merging of code, testing, staging, and finally, deployment. As changes are merged into the central repository, they are already on their way to the end users

![cd2](cd2.png)

Benefits of CD:
 - Rapid development process
 - Rapid feedback
 - Smaller and less risky releases
 - Regular updates offering users improvements

Costs of CD:
 - Requires substantial initial investment
   - Money
   - Time
   - Major paradigm shift
 - Requires continuous investment for maintaining pipeline
 - Documentation, communication, coordination become even more important

## Static Code Analysis Tools
Static testing is common in the DevOps process, and there are code quality tools that help you find code "smells" in your application. These are things like:
- Data security issues
- Bugs
- confusing code
- redundant code
- unused imports
- empty code blocks
- etc.

Most IDEs have code quality tools built in, but these can provide more in-depth analysis of your code:
- SonarCloud
    - A cloud-based static code analyzer that can review code loaded into a cloud-based repository, like github
        - Navigate to the Sonar Cloud Login Page, and select "Log in with Github"
        - Click on "Analyze your code" and follow the steps for project setup
        - Select the repository to analyze.
- SonarQube
    - A code review tool that can be built into a DevOps pipeline. Typically considered a more "powerful" tool because of its configurability
- SonarLint
    - an open source plugin for many ides, it can be installed from your IDE's plugin marketplace

## Jenkins

### Introduction to Jenkins
Jenkins is a popular open source DevOps tool: it allows you to create a DevOps pipeline where your pushes to the main github repo of your project will trigger Jenkins to clone your code to your EC2, test it, build it, and run it (There are other use cases, of course, but this is closest to how we can use it in training). There are many steps involved, and not all are necessary depending on the type of program you are running or the level of automation you want in your Continuous Delivery DevOps practice.

A typical Jenkins instance will have a main controller that facilitates your DevOps operations and then worker nodes that actually execute your jobs (this is configured in the Jenkins main controller itself), but for small DevOps jobs the main controller can handle executing your **Jobs** itself

### Jenkins Jobs and Builds
A Jenkins **Job** and **Build** represent different aspects of a DevOps process. 

A **Job** is what we call one or more associated tasks we configure Jenkins to execute to facilitate our DevOps pipeline. This can be actions such as cloning a repository, running tests, pushing test reports to a remote location, emailing notifications and/or results to designated individuals, starting or restarting applications depending on if a build succeeds or not, or any other action you want to happen as part of the DevOps process. Jenkins supports different configuration options for your jobs, two of the main options being a **Freestyle** and **Pipeline** job:
- **Freestyle** jobs are set up through the Jenkins UI Directly, tend to involve fewer steps, and are easier to set up than other job options. That being said, they don't scale as well for more complex DevOps jobs, so they tend to be used for smaller DevOps jobs
- **Pipeline** jobs have their initial configuration set up in the Jenkins UI, but the actual steps and actions involved in the job are typically saved in a **Jenkinsfile** that is saved in the SCM repository. The **Jenkinsfile** is written in Groovy Syntax, and it makes it much easier to determine the actions and agents involved in the actions that need to be taken. This allows for scaling the work done in a DevOps process to a greater degree than a **Freestyle** job because the Groov syntax allows for configuring your DevOps job programmatically, as opposed to configuring it via an options UI

A **Build** is what we call the output of a Jenkins **Job**. Any compiled code, test results, build artifacts, and **Job** outputs (job results, logs generated, etc) are considered part of the **Build**. The resources created in a **Build** can be used further down the line in the DevOps process, or they can be archived for logging purposes

### Creating a DevOps Pipeline (CICD pipeline) With Jenkins
**Note**: this example will focus on creating a freestyle project and uses the recommended default plugins

Configuration Options:
- **General**
    - This is where you can set information such as the description, github project url, and determine how many previous builds to keep
- **Source Code Management**
    - this is where you set what repository you want to clone for the job, and where you provide the git credentials necessary to interact with the repository using Jenkins managed credentials
- **Build Triggers**
    - if you want your job to trigger automatically you determine how that is done in this section. This can be a Github web hook, completion of another job, timer based, and more
- **Build Environment**
    - this is where you can provide extra information to Jenkins to configure the environment Jenkins will execute the job in: these are things like environment variables that only exist during the job, instructions for whether to delete old workspaces or not, and what to do if the job times out
- **Build Steps/Post Build Steps**
    - these are the actual commands Jenkins will execute during your Job execution. Build steps execution happens before the Build is completed, Post-Build steps happen after the build is completed

### Jenkins Credentials Management
Many Jenkins plugins abstract away using third party tools like Git and SSH. In order for these plugins to work properly they have to be provided proper credentials: Jenkins Credentials Management allows you to provide this data to the plugins will keeping them hidden from plain-text use in your Jobs, though many credential details will be available to users that can interact with the Jenkins instance. Depending on what kind of credentials a plugin needs, you will have to change the type of credential being saved in the management tool.

### Jenkins Plugins and Integrations
Plugins and Integrations are ways of modifying the default implementation of a Jenkins instance. Plugins are direct add-ons that extend the functionality of your Jenkins software. These can change the way you interact with the UI in Jenkins itself and modify the behavior of your Jobs. 

Integrations are third party software the connect with Jenkins to help facilitate your Jobs, but are not a part of Jenkins directly. Git is a good example of an Integration: Jenkins has a lot of compatability with Git, and even has many plugins that make it easier to automate using Git, but Git is not actually part of the Jenkins application. They simply "integrate" well together

### WebHooks
A common way of triggering automated Jenkins Jobs is to use WebHooks: a WebHook is typically an HTTP request made to your Jenkins instance that can trigger a Job to start. In order to make use of a WebHook you have to configure your instance to listen for a web hook (typically done in the configurations of the Job you want automated by the WebHook) and then in your third party tool (like Github) you have to configure the service to to make an HTTP request (this is the hook) to your Jenkins application. This requires that Github or whatever service is making the request have permission to interact with your Jenkins instance: in AWS this is handled by configuring your security groups to allow Github access to Jenkins