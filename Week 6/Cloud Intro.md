# Cloud Intro
Cloud = on a computer someone else owns

Cloud Provider = a company that offers their infrastructure (aka their computers) for your computing needs

cloud infrastructure = physical hardware

## Amazon Web Services
some of the benefits that AWS offers (along with most other cloud providers)
- Trade capital expense for variable expense
- Benefit from massive economies of scale
- Stop guessing about capacity
- Increase speed and agility
- Eliminate overhead cost of maintaining data centers
- **Go global in minutes**

## Cloud Models
- Infrastructure as a Service (IaaS)
    - offering use of the data centers and physical hardware the cloud company owns
    - AWS and other cloud companies are essentially IaaS offerings: they allow us to use their data centers and hardware for a fraction of the price it would cost for us to set up our own infrastructure
- Platform as a Service (PaaS)
    - allows for building, running, and managing applications without the IT infrastructure
        - Relational Database Service (RDS), Elastic Cloud Compute (EC2), and Simple Storage Solution (S3) are examples of AWS PaaS. These services are managed by Amazon, you simply tell AWS what specs you need and they provide them for you and management them for a fee
- Software as a Service (SaaS)
    - replacement for the traditional desktop applications, typically through web access
        - Workday is an example of SaaS

## Regions & Availability Zones
- Region = geographic location where one or more AWS services are available
- Availability Zones = areas that contain the actual data centers
    - these locations have their own redundant power sources, networking, and connectivity options to help maintain high availability and reliability

## Services we Will go Over
- Relational Database Service (RDS)
    - This service offers database hosting: AWS handles spinning up a virtual computer, downloading the database software, and setting up the database according to your specifications. They manage the software and environment, so all you have to do is set up the database according to your needs
- Elastic Cloud Compute (EC2)
    - this service offers virtual machines: no one has direct access to the hardware AWS uses, instead Amazon partitions portions of the resources available on their hardware to virtual machines that end users can use for their purposes
        - application deployment
        - build pipelines
        - testing
        - experimenting
- Simple Storage Service (S3)
    - this service offers object storage: if it is digital, you can probably store it in an S3 "bucket". Final applications (think a finished JAR) can be stored, configuration data can be stored, photos, anything digital can be stored in a bucket. S3 can even be used for static website hosting