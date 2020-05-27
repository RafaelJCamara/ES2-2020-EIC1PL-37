
node {

stage('Git Checkout') {
    git 'https://github.com/rjafc-iscteiul/ES2-2020-EIC1PL-37.git'
    }
    
stage('Build WP and MYSQL Docker Image'){
     powershell "docker-compose up -d"
    }
    
stage('Build Java Docker Image Part 1'){
     powershell "docker build -t helloworld ."
    }  
  
stage('Build Java Docker Image Part 2'){
     powershell "docker run -d 8002:8002 helloworld"
    }      
    
}
