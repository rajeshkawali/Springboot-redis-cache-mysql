# Springboot-redis-cache-mysql
Spring boot, MySQL and integration with Redis Cache (Docker - Redis)

# To download redis:
C:\Users\rajes> docker pull redis

# First start Redis in the docker:
C:\Users\rajes> docker run --name my-redis -d redis
or
C:\Users\rajes> docker run --name my-redis -p 6379:6379 -d redis

# To check the redis server status:
C:\Users\rajes> docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED          STATUS          PORTS      NAMES
78dfb704c1fd   redis     "docker-entrypoint.s…"   14 seconds ago   Up 13 seconds   6379/tcp   my-redis

# To get inside redis server:
C:\Users\rajes> docker exec -it my-redis redis-cli

# To interact with Redis cache:
127.0.0.1:6379> set mykey rajesh
OK
127.0.0.1:6379> get mykey
"rajesh"
127.0.0.1:6379>