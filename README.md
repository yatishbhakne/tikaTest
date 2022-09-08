# Build

```bash
sbt docker:publishLocal
```

# Usage

Mount a local dir as images directory (e.g. /work/experiments/tikaTest/images below), and use the target as base directory for arguments

```bash
docker run --mount type=bind,source=/work/experiments/tikaTest/images,target=/app/images yatishbhakne/tika-test:0.1.0-SNAPSHOT /app/images/im6.svg
```

