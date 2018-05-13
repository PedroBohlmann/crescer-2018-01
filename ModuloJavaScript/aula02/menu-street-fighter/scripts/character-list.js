import Character from './character'
class CharacterList{
    constructor(){
        this.characterList = Array()
        this.flags = {}
        this._configureCharacters()
        this.loadCharacters()
        this.loadInfoFromActiveCharacter()
        this._configureButtons()
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
            if(allCharacters[i].hasOwnProperty('secret')){
                secret=allCharacters[i].secret
            }

            const newCharacter = new Character(name,smallImg,largeImg,height,fighting,skills,birth, active, secret,this._generateId())
            this.characterList.push(newCharacter)
        }
    }

    _configureButtons(){
        for(let i=0;i<this.characterList.length;i++){
            const img = document.getElementById(this.characterList[i].id)
            img.addEventListener('click',event=>{
                this.removeActiveCharacter()

                this.characterList[i].letActive()
                img.classList.add('active-character')
                
                this.loadInfoFromActiveCharacter()
            })
        }
    }

    loadCharacters(){
        for(let i=0;i<this.characterList.length;i++){
            const img = document.createElement('img')
            img.classList.add('head-shot-image')
            img.src = this.characterList[i].smallImg;
            img.id = this.characterList[i].id

            if(this.characterList[i].active===true){
                img.classList.add('active-character')
            }

            if(this.characterList[i].secret===true){
                img.classList.add('secret-character')
            }

            characterTable.appendChild(img)
        }
    }

    loadInfoFromActiveCharacter(){
        for(let i=0;i<this.characterList.length;i++){
            if(this.characterList[i].active){
                characterName.innerHTML= this.characterList[i].name
                characterHeight.innerHTML=this.characterList[i].height
                characterFighting.innerHTML = this.characterList[i].fighting
                characterSkills.innerHTML=this.characterList[i].skills
                characterMainImage.src=this.characterList[i].largeImg
            }
        }
    }

    removeActiveCharacter(){
        for(let i=0;i<this.characterList.length;i++){
            if(!!this.characterList[i].active==true){
                const activeCharacter = this.characterList[i]
                activeCharacter.letInactive()
                const img = document.getElementById(activeCharacter.id)
                img.classList.remove('active-character')
            }
        }
        return null
    }

    loadFlag(){
        this.flags = {
            br:'assets/flags/br.png',
            cn:'assets/flags/cn.png',
            gb:'assets/flags/gb.png',
            jm:'assets/flags/jm.png',
            jp:'assets/flags/jp.png',
            ru:'assets/flags/ru.png',
            th:'assets/flags/th.png',
            us:'assets/flags/us.png'
        }
    }

    changeBackground(flag){
        
    }
}

export default CharacterList