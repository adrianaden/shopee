docker rmi adrianaden/shopee-api
docker rmi adrianaden/shopee-web
docker rmi adrianaden/shopee-db

cd api && mvn clean install && docker build -t adrianaden/shopee-api .
cd ..
cd web && docker build -t adrianaden/shopee-web .
cd ..
cd db && docker build -t adrianaden/shopee-db .
cd ..
