import $ from 'jquery'
import _ from 'jquery-validation'

import HomeService from './services/home-service'

class HomeForm{
    configure(){
        this._configureNewPostButton()
        this._loadAllPosts()
        $('#homeForm').validate({
            rules:{
                title:{
                    required:true
                },
                text:{
                    required:true
                }
            },
            submitHandler: function(form){
                this._createPost()
                this._switchNewPostVisibilitie()
            }.bind(this)
        })
    }

    _configureNewPostButton(){
        newPostButton.addEventListener('click',this._switchNewPostVisibilitie)
    }

    _switchNewPostVisibilitie(){
        if($("#newPostBlock").hasClass("invisible")){//se ta invisivel
            $("#newPostButton").addClass("invisible")//botao visivel
            $("#newPostBlock").removeClass("invisible")
        }else{
            $("#newPostButton").removeClass("invisible")//bloco esta visivel e tira o botao
            $("#newPostBlock").addClass("invisible")
        }
    }

    _createPost(){
        const titleTxt= title.value
        const newPostContent = text.value

        HomeService.createPost(titleTxt,newPostContent)
            .then(result=>{
                console.log(result)
                console.log('Deu o post')
                this._loadPost(titleTxt,newPostContent)
            })
            .catch(error=>{
                console.log(error.message)
            })
    }

    _loadPost(title,text){
        const card = document.createElement('div')
        card.classList.add('card')

        const cardBody = document.createElement('div')
        cardBody.classList.add('card-body')

        const cardTitle = document.createElement('h4')
        cardTitle.classList.add('card-title')
        cardTitle.innerHTML = title

        const cardText = document.createElement('p')
        cardText.classList.add('card-text')
        cardText.innerHTML = text

        const textRight = document.createElement('div')
        textRight.classList.add('text-right')

        const buttonLink = document.createElement('a')
        buttonLink.href ='#'
        buttonLink.classList.add('btn')
        buttonLink.classList.add('btn-primary')
        buttonLink.innerHTML = '+1'

        textRight.appendChild(buttonLink)

        cardBody.appendChild(cardTitle)
        cardBody.appendChild(cardText)
        cardBody.appendChild(textRight)

        card.appendChild(cardBody)

        allPosts.appendChild(card)

    }

    _loadAllPosts(){
        HomeService.loadAllPosts()
            .then(result=>{
                const allPostsArray = result.data.posts
                for(let i=0;i<allPostsArray.length;i++){
                    this._loadPost(allPostsArray[i].title,allPostsArray[i].text)
                }
            })
            .catch(error=>{
                if(error.request.status===401){
                    alert('Você precisa estar logado')
                    window.location = './login.html'
                }
            })
    }

}

const homeForm = new HomeForm()
homeForm.configure()