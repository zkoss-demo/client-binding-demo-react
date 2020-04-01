# client-binding-demo-react

## Prerequisites

* Java 8
* Node.js

## Run the Demo

### Production mode (static, minified js/css)

```bash
./gradlew staticBuild bootRun
```

http://localhost:8080

### Development mode (live-reload js/css)

**ZK App**
```bash
SPRING_PROFILES_ACTIVE=dev ./gradlew bootRun
```

from IDE run main class `react.App` (with vm options: `-Dspring.profiles.active=dev`)


**React App**
```bash
cd frontend
npm start
```

http://localhost:3000/dev

* react JS/CSS will reload the page automatically (live-reload) 
* zk resources require re-build/compile (in IDE) and browser-refresh (without restarting server)

### Tests

**React Tests**
```bash
cd frontend
npm test
```

**Webdriver-io Test** (with ZK/React App running in development mode)
```bash
cd frontend
npm run wdio
```

## Package/Run Demo

```bash
./gradlew clean staticBuild build
java -jar build/libs/client-binding-demo-react-0.0.1-SNAPSHOT.jar
```


## License

* Demo Code - Apache License 2.0
* react-shopping-cart - MIT
