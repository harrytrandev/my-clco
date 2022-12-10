# Final Project of Cloud Computing Class
## Project name: Create an application that combines multiple dockers together
### Instructor: Dr.Phung Huynh Xuan
## Tech used:
- Gitlab CI/CD 
- Docker 
- AWS EC2 
- Mysql
- Java + C#

## Guide
### Step 1: Create and configure instances
- The first thing, we have to create 5 instance and allocate with each elastic ip address

| Instance | function | port |
| ------ | ------ | ------ |
| UI |  deploy Web user interface | 5000 |
| DB | deploy database MySql | 3306 |
| API1 | deploy backend1 | 8080 |
| API2 | deploy backend2 | 8080 |
| Gitlab-Runner | install and deploy gitlab runner | none |

After, make sure that all instance is running and have enough permission
### Step 2: Deploy Gitlab-CI/CD

- You could install runner in a lot of environment, in this Project
I will install runner in Linux with architecture  adm64 in following steps:
-  Download the binary for your system
``` bash
sudo curl -L --output /usr/local/bin/gitlab-runner https://gitlab-runner-downloads.s3.amazonaws.com/latest/binaries/gitlab-runner-linux-amd64
- # Give it permission to execute
sudo chmod +x /usr/local/bin/gitlab-runner
- # Create a GitLab Runner user
sudo useradd --comment 'GitLab Runner' --create-home gitlab-runner --shell /bin/bash
- # Install and run as a service
sudo gitlab-runner install --user=gitlab-runner --working-directory=/home/gitlab-runner
sudo gitlab-runner start
```
The Final step is register runner
Command to register runner:
``` bash
sudo gitlab-runner register --url https://gitlab.com/ --registration-token $REGISTRATION_TOKEN
# $REGISTRATION_TOKEN is display on Setting CICD > Runner Specific
```

To check the status of gitlab runner, use command
``` bash
gitlab-runner verify
```
- Create .gitlab-ci.yml 
You can see the format of this file in my repos
- Create Variables is used in .gitlab-ci.yml

And finally, commit code and you can watch running process in each pipeline in the Pipeline Tab of GitLab

**Contact me if you have any problems while deploy website.**
_@ hongocbien0912@gmail.com_

