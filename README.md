# Springboot-redis-cache-mysql
Spring boot, MySQL and integration with Redis Cache (Docker - Redis)

# To download redis:
docker pull redis

# First start Redis in the docker:
docker run --name my-redis -d redis
#or
docker run --name my-redis -p 6379:6379 -d redis

# To check the redis server status:
docker ps

# To get inside redis server:
docker exec -it my-redis redis-cli

# To set the key value:
127.0.0.1:6379> set mykey rajesh
OK

# To get the value by providing key:
127.0.0.1:6379> get mykey
"rajesh"
