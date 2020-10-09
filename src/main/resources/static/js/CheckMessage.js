
    var app = new Vue({
    el:"#app",
    data:{
    phoneValue:"",
    phone_number:"",
    password:"",
    copy_password:"",
    code:"",
    phone_code:"",
},
        created: function ()  //将vue中js函数绑定在全局上
        {
            window.check_message = this.check_message;
        },
    methods:{
    check_message:function ()//检验注册信息是否合格
    {

    if(!this.phoneValue)
{
    alert("手机号不能为空！")
    return false;
}
    else
{
    this.phone_number=this.phoneValue;
    if(!(/^1[3|4|5|8][0-9]\d{8}$/.test(this.phone_number)))
    {
    alert("不是完整的11位手机号或者正确的手机号");
    return false;
}
}
    // this.code=this.code.replace(/\s*/g,"");
    // this.phone_code=this.phone_code.replace(/\s*/g,"");

    if (!(/^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).*$/.test(this.password))){
    alert("密码必须含大小写字母和数字")
    return false;
}
    if (this.password!==this.copy_password){
    alert("重复密码不正确");
    return false;
}
    // if (this.code!==this.phone_code){
    //         alert("验证码不正确")
    //         return false;
    //     }
    return true;
},
    send: async function ()   //将信息发送给后端接口
    {
        await axios.get("http://localhost:8082/register/phone?phone=" + this.phoneValue)
            .then(res=>{
                this.code = res.data;
            })
    }


}
})

