class Character{
    constructor(name,smallImg,largeImg,height,fighting,skills,birth,active,secret,id){
        this.name = name
        this.smallImg = smallImg
        this.largeImg = largeImg
        this.height = height
        this.fighting = fighting
        this.skills = skills
        this.birth = birth
        this.active = active
        this.secret = secret
        this.id=id
    }

    letActive(){
        this.active = true
    }

    letInactive(){
        this.active = false
    }
}

export default Character