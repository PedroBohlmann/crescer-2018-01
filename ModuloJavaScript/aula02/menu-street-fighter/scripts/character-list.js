import Character from './character'
const KONAMI_CODE_VALID_KEYS=[38,40,37,39,66,65,13]
const KONAMI_CODE_VALID_SEQUENCE=[38,38,40,40,37,39,37,39,66,65,13]
class CharacterList{
    constructor(){
        this.characterList = Array()
        this.flags = {}
        this.inputSequence = Array()
        this._loadFlag()
        this._configureCharacters()
        this._loadCharacters()
        this._loadInfoFromActiveCharacter()
        this._configureButtons()
        this._configureKonamiCodeListener()
    }

    _generateId() {
		function s4() {
			return Math.floor((1 + Math.random()) * 0x10000)
				.toString(16)
				.substring(1)
		}
		return (
			s4() +
			s4() +
			'-' +
			s4() +
			'-' +
			s4() +
			'-' +
			s4() +
			'-' +
			s4() +
			s4() +
			s4()
		)
    }

    _configureCharacters(){
        const allCharacters = [
            {
              name: 'Ryu',
              smallImg: 'assets/images/characters/ryu_headshot.jpg',
              largeImg: 'assets/images/characters/ryu.png',
              height: '5"9',
              fighting: 'Ansatsuken',
              skills: 'Sleeping anywhere',
              birth: 'jp',
              active: true
            },
            {
              name: 'Ken',
              smallImg: 'assets/images/characters/ken_headshot.jpg',
              largeImg: 'assets/images/characters/ken.png',
              height: '5"9',
              fighting: 'Ansatsuken',
              skills: 'Cooking pasta',
              birth: 'us',
            },
            {
              name: 'Chun-Li',
              smallImg: 'assets/images/characters/chun_li_headshot.jpg',
              largeImg: 'assets/images/characters/chun_li.png',
              height: '5"6',
              fighting: 'Chinese martial arts',
              skills: 'Shooting',
              birth: 'cn',
            },
            {
              name: 'Dee Jay',
              smallImg: 'assets/images/characters/dj_headshot.jpg',
              largeImg: 'assets/images/characters/dj.png',
              height: '6"1',
              fighting: 'Kickboxing',
              skills: 'Bamboo dancing',
              birth: 'jm',
            },
            {
              name: 'Cammy',
              smallImg: 'assets/images/characters/cammy_headshot.jpg',
              largeImg: 'assets/images/characters/cammy.png',
              height: '5"5',
              fighting: 'Shadaloo/Special Forces Training',
              skills: 'Knife throwing',
              birth: 'gb',
            },
            {
              name: 'Sagat',
              smallImg: 'assets/images/characters/sagat_headshot.jpg',
              largeImg: 'assets/images/characters/sagat.png',
              height: '7"5',
              fighting: 'Muay Thai',
              skills: 'Breathing underwater',
              birth: 'th',
            },
            {
              name: 'Zangief',
              smallImg: 'assets/images/characters/zangief_headshot.jpg',
              largeImg: 'assets/images/characters/zangief.png',
              height: '7"0',
              fighting: 'Russian/American Pro Wrestling',
              skills: 'Resistance to cold',
              birth: 'ru',
            },
            {
              name: 'Akuma',
              smallImg: 'assets/images/characters/akuma_headshot.jpg',
              largeImg: 'assets/images/characters/akuma.png',
              height: '5"10',
              fighting: 'Satsui no Hado/Ansatsuken',
              skills: 'Martial Arts',
              birth: 'jp',
            },
            {
              name: 'Blanka',
              smallImg: 'assets/images/characters/blanka_headshot.jpg',
              largeImg: 'assets/images/characters/blanka.png',
              height: '6"4',
              fighting: 'Feral movement, electric attacks',
              skills: 'Hunting',
              birth: 'br',
            },
            {
              name: 'Silvio',
              smallImg: 'assets/images/characters/silvio_headshot.png',
              largeImg: 'assets/images/characters/silvio.png',
              height: '6"0',
              fighting: 'Strategist',
              skills: 'Money planes throwing',
              birth: 'br',
              secret: true,
            },
          ]
        
          for(let i=0;i<allCharacters.length;i++){
            const name = allCharacters[i].name
            const smallImg = allCharacters[i].smallImg
            const largeImg = allCharacters[i].largeImg
            const height = allCharacters[i].height
            const fighting = allCharacters[i].fighting
            const skills =allCharacters[i].skills
            const birth = allCharacters[i].birth
            let active = false
            let secret = false
            if(allCharacters[i].hasOwnProperty('active')){
                active=allCharacters[i].active
            }
            if(allCharacters[i].hasOwnProperty('secret') && localStorage.silvioUnlocked==undefined){
                secret=allCharacters[i].secret
            }

            const newCharacter = new Character(name,smallImg,largeImg,height,fighting,skills,birth, active, secret,this._generateId())
            this.characterList.push(newCharacter)
        }
    }

    _configureButtons(){
        for(let i=0;i<this.characterList.length;i++){
            const div = document.getElementById(this.characterList[i].id)
            div.addEventListener('click',event=>{
                if(this.characterList[i].secret==false){
                    this._removeActiveCharacter()

                    this.characterList[i].letActive()
                    div.classList.add('active-character')
                    div.classList.add('image-blinking')

                    const divName = document.createElement('div')
                    divName.innerHTML = this.characterList[i].name

                    divName.classList.add('head-shot-name')
                    
                    div.appendChild(divName)
                    this._loadInfoFromActiveCharacter()
                    this._changeBackground(this.characterList[i].birth)
                }
            })
        }
    }

    _configureKonamiCodeListener(){
        body.addEventListener('keydown', event => {
			if(this._validateKonamiCodeInput(event.keyCode)){
                this.inputSequence.push(event.keyCode)
                console.log(event.keyCode)
                if(this.inputSequence.length===11){
                    if(this._validateKonamiCodeSequence()){
                        const secretCharacter = this.searchSecretCharacter()
                        secretCharacter.unlock()
                        document.getElementById(secretCharacter.id).classList.remove('secret-character')
                        localStorage.silvioUnlocked = true

                        const message = document.createElement('span')
                        message.classList.add('secret-message')
                        
                        message.innerHTML = "Unlocked"

                        body.appendChild(message)

                    }
                    else{
                        this.inputSequence=[]
                    }
                }
            }
            else{
                this.inputSequence = []
            }
		})
    }

    _validateKonamiCodeInput(input){
        let cont=0
        for(let i=0;i<KONAMI_CODE_VALID_KEYS.length;i++){
            if(input===KONAMI_CODE_VALID_KEYS[i]){
                cont++
            }
        }
        return cont>0
    }

    _validateKonamiCodeSequence(){
        let cont = 0
        for(let i=0;i<this.inputSequence.length;i++){
            if(this.inputSequence[i]===KONAMI_CODE_VALID_SEQUENCE[i]){
                cont++
            }
        }
        return cont===11

    }

    searchSecretCharacter(){
        for(let i=0;i<this.characterList.length;i++){
            if(this.characterList[i].secret===true){
                return this.characterList[i]
            }
        }
    }

    _loadCharacters(){
        for(let i=0;i<this.characterList.length;i++){
            const div = document.createElement('div')
            const img = document.createElement('img')
            div.classList.add('head-shot-image')
            div.style.background = "url('"+this.characterList[i].smallImg+"')";
            div.style.backgroundSize ='contain'
            div.id = this.characterList[i].id

            if(this.characterList[i].active===true){
                div.classList.add('active-character')

                const divName = document.createElement('div')
                divName.innerHTML = this.characterList[i].name
                divName.classList.add('head-shot-name')
                div.appendChild(divName)
            }

            if(this.characterList[i].secret===true){
                div.classList.add('secret-character')
            }
            // div.appendChild(img)
            characterTable.appendChild(div)
        }
    }

    _loadInfoFromActiveCharacter(){
        for(let i=0;i<this.characterList.length;i++){
            if(this.characterList[i].active){
                characterName.innerHTML= this.characterList[i].name
                characterHeight.innerHTML=this.characterList[i].height
                characterFighting.innerHTML = this.characterList[i].fighting
                characterSkills.innerHTML=this.characterList[i].skills
                characterMainImage.src=this.characterList[i].largeImg
                this._changeBackground(this.characterList[i].birth)
                
                characterMainImage.classList.remove('character-main-image-animation')
                setTimeout(function(){ characterMainImage.classList.add('character-main-image-animation') })
            }
        }
    }

    _removeActiveCharacter(){
        for(let i=0;i<this.characterList.length;i++){
            if(!!this.characterList[i].active==true){
                const activeCharacter = this.characterList[i]
                activeCharacter.letInactive()
                const div = document.getElementById(activeCharacter.id)
                div.classList.remove('active-character')
                div.classList.remove('image-blinking')
                div.getElementsByClassName('head-shot-name')[0].remove()
            }
        }
        return null
    }

    _loadFlag(){
        this.flags = {
            br:"assets/images/flags/br.png",
            brGrad:'linear-gradient(rgba(102, 101, 101,0.75),rgba(0, 153, 59,0.75))',
            cn:"assets/images/flags/cn.png",
            cnGrad:'linear-gradient(rgba(102, 101, 101,0.75),rgba(75,0,0,0.75))',
            gb:"assets/images/flags/gb.png",
            gbGrad:'linear-gradient(rgba(102, 101, 101,0.75),rgba(0, 118, 198,0.75))',
            jm:"assets/images/flags/jm.png",
            jmGrad:'linear-gradient(rgba(102, 101, 101,0.75),rgba(106, 156, 48,0.75))',
            jp:"assets/images/flags/jp.png",
            jpGrad:'linear-gradient(rgba(102, 101, 101,0.75),rgba(75,0,0,0.75))',
            ru:"assets/images/flags/ru.png",
            ruGrad:'linear-gradient(rgba(102, 101, 101,0.75),rgba(42, 0, 230,0.75))',
            th:"assets/images/flags/th.png",
            thGrad:'linear-gradient(rgba(102, 101, 101,0.75),rgba(4, 16, 130,0.75))',
            us:"assets/images/flags/us.png",
            usGrad:'linear-gradient(rgba(102, 101, 101,0.75),rgba(0, 32, 108,0.75))'
        }
    }

    _changeBackground(flag){
        const backgroundURL=this.flags[flag]
        const backgroundGrad=this.flags[flag+'Grad']
        document.body.style.background = backgroundGrad+",url('"+backgroundURL+"')"
        document.body.style.backgroundRepeat='no-repeat, no-repeat'
        document.body.style.backgroundSize='100% 100%, 100% 100%'
    }

}

export default CharacterList