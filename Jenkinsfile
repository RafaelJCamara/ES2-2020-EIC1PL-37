
node {

stage('Git Checkout') {
    git 'https://github.com/rjafc-iscteiul/ES2-2020-EIC1PL-37.git'
    }
    
stage('Build Docker Imagae'){
     powershell "docker-compose up -d"
    }
    
}
