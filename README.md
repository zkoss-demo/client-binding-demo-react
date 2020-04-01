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

ZK App
```bash
SPRING_PROFILES_ACTIVE=dev ./gradlew bootRun
```

React App
```bash
cd frontend
npm start
```

http://localhost:3000/dev

changes to
* frontend JS/CSS will reload the page automatically (live-reload) 
* zk resources require re-build and browser-refresh (without restarting)

### Tests

React Tests
```bash
npm test
```

Webdriver-io Test (with ZK/React App running in development mode)
```bash
npm run wdio
```

## License

* Demo Code - Apache License 2.0
* react-shopping-cart - MIT
