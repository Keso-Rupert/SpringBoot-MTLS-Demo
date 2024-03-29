# SpringBoot-MTLS-Demo
Demo application to test and show how to configure MTLS with the SslBundles

## Generating MTLS certificates

### Certificate Authority (CA)

`openssl req -new -x509 -days 9999 -keyout ca-key.pem -out ca-crt.pem`

### Server certificates

`openssl genrsa -out server-key.pem 4096`

`openssl req -new -key server-key.pem -out server-csr.pem`

`openssl x509 -req -days 9999 -in server-csr.pem -CA ca-crt.pem -CAkey ca-key.pem -CAcreateserial -out server-crt.pem`

### Client certificates

`openssl genrsa -out client-key.pem 4096`

`openssl req -new -key client-key.pem -out client-csr.pem`

`openssl x509 -req -days 9999 -in client-csr.pem -CA ca-crt.pem -CAkey ca-key.pem -CAcreateserial -out client-crt.pem`

## Source
Main source and inspiration for this MTLS demo is this article about the introduction of SSL Bundles:
https://spring.io/blog/2023/06/07/securing-spring-boot-applications-with-ssl


https://medium.com/weekly-webtips/how-to-generate-keys-for-mutual-tls-authentication-a90f53bcec64