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

## AWS RDS
RDS is a collection of services for operating a relational database server in the cloud. Take note of the three distinct things that we often call "databases":

- Database Server: A server like any other which hosts the engine
- Database Engine: The software that allows manipulation of the database
- Database: one or more files that store data in a systematic way

Amazon RDS helps us manage the Database Server and related infrastructure. We can choose our Database Engine (or management system) from one of the many implementations of SQL including: MySQL, PostgreSQL, MariaDB, and Microsoft SQL Server. Amazon even has its own implementation called Aurora.

An RDS instance is little more than an EC2 instance that has the RDBMS, or the Database Engine, installed and configured out-of-the-box. Your RDS instance can scale vertically, and can be set up to scale horizontally as well, though these features aren't covered by free tier. May features of the service can be handled by AWS (updates to the RDBMS, automated backups, data encryption) but not all of these offerings are strictly free tier. For instance, by default, AWS assumes you want your instance to auto scale storage up to 1000G, which is a value not covered by free tier. You as the developer have to turn off the feature

### Security Groups
A Security Group controls incoming and outgoing traffic to and from one or more resources (like an EC2 instance). A VPC, or Virtual Private Cloud, is a logical grouping of AWS resources into a virtual network. A Security Group can only be applied to resources which exist inside its VPC.

Security Groups control traffic with rules. Rules make determinations about what traffic is allowed based on the following parameters:
- Protocol
- Port
- ICMP Type (Internet Control Message Protocol)
- Source or Destination
