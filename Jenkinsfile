node {

stage('Git Checkout') {
    git 'https://github.com/rjafc-iscteiul/ES2-2020-EIC1PL-37'
    }
    
stage('Build Docker Image for Java'){
     powershell "docker build -t my-java-app ."
    }

stage('Build Docker Image for Java'){
     powershell "docker run -it --name my-running-app my-java-app"
    }
	
}
