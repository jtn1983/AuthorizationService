````
worker_processes 1;
error_log /usr/local/var/log/nginx/error.log;

events {
    worker_connections  1024;
}

http {
    # This should be in the same directory as this conf
    # e.g. /usr/local/etc/nginx
    include       mime.types;
    default_type  application/octet-stream;
    
    # Note this log_format is named 'main', and is used with the access log below
    log_format   main '$remote_addr - $remote_user [$time_local]  $status '
    '"$request" $body_bytes_sent "$http_referer" '
    '"$http_user_agent" "$http_x_forwarded_for"';
    
    sendfile        on;
    keepalive_timeout  65;
    
    proxy_buffer_size   128k;
    proxy_buffers   4 256k;
    proxy_busy_buffers_size   256k;
    
    server {
        listen 80;
        server_name localhost;
        access_log /usr/local/var/log/nginx/signin.access.log  main;
        
        location /signin {
            proxy_pass  http://localhost:8080/auth.html;
        }
        
        location / {
            proxy_pass  http://localhost:8080;
        }
}