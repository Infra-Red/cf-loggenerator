# LogGenerator - a simple Java worker for Cloud Foundry

### Pushing the app to Cloud Foundry

```
cf push
```

### Pushing the app to Cloud Foundry as a Docker image

LogGenerator is packaged as a docker image at [andreikrasnitski/cf-loggenerator](https://hub.docker.com/r/andreikrasnitski/cf-loggenerator/)

To push to [Diego](https://github.com/cloudfoundry-incubator/diego-release):

```bash
cf push loggenerator -o andreikrasnitski/cf-loggenerator -health-check-type none
```
