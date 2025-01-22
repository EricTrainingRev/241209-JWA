# Jenkins
Instructions taken from Jenkins documentation [here](https://www.jenkins.io/doc/book/installing/linux/). Depending on Linux instance and package management software, will need to search for specific use case. **NOTE** newer version of Jenkins require Java 17 to work correctly
- connect to instance
- add jenkins repo to Yum options, upgrade Yum, install jenkins
```bash
sudo wget -O /etc/yum.repos.d/jenkins.repo \
    https://pkg.jenkins.io/redhat/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat/jenkins.io-2023.key
sudo yum upgrade
# Add required dependencies for the jenkins package
sudo yum install fontconfig java-17-openjdk
sudo yum install jenkins
```
- optional: setup autostart for Jenkins, could be useful with instances that start/stop consistently
```bash
sudo systemctl enable jenkins
```
- optional: check status of Jenkins
    - this can also be used to check the logs of Jenkins, which can tell you where your initial password is located
```bash
sudo systemctl status jenkins
```
- optional: manually start Jenkins
```bash
sudo systemctl start jenkins
```
- Jenkins uses port 8080 by default, if you want to change this you can edit Jenkins to use a new option
```bash
systemctl edit jenkins
```
```bash
[Service]
Environment="JENKINS_PORT={port number goes here}"
```
- **NOTE**: Jenkins requires jdk 17, if it is not selected as your Java version Jenkins will fail to start

## Script Note
if you want to change your script depending on the mvn test:
```bash
mvn clean test
if [ $? -eq 0 ]; then
	echo "Maven tests successful"
else
	echo "Maven tests failed"
fi
```