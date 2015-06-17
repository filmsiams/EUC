package projectpea


class LogComposer extends zk.grails.Composer {

    def afterCompose = { window ->
        Date date = new Date()       
        java.text.SimpleDateFormat tf = new java.text.SimpleDateFormat()        
        tf.applyPattern("HH:mm:ss")

        $('#userlogin').val(session.user)
        def ckn = Logincheck.findByUser(session.user)
        if(ckn == null){
            alert("ท่านยังไม่ทำการ login ค่ะ")
            redirect(uri: "/login.zul")
        }else if(session.claim != "Admin"){
            alert("เฉพาะ Admin เท่านั้น")
            redirect(uri: "/index.zul")
        }else{

        }

        $('#logout').on('click',{
          def del = Logincheck.findByUser(session.user)
            def ch = Employee.findByEmid(session.user)
                def outadd = Logindata.findByCkin(session.ckin)


            if(ch != null){

                ch.cedit = ""
                ch.editin = ""
                ch.save()
            }else{
                      
            }
                

          if(del != null){            

            outadd.timelogout = tf.format(date)
            outadd.ckin = "out"
            outadd.save()

            session.ckin = ""
            session.user = ""
            session.claim = ""            
            del.delete()

            redirect(uri: "/login.zul")
          }else{
            redirect(uri: "/login.zul")
          }
    })
        for(Logindata e : Logindata.findAll()){
            
            $('#listuser > rows').append{
                row{
                    label(value:e.id)
                    label(value:e.user)
                    label(value:e.date)
                    label(value:e.timelogin)
                    label(value:e.timelogout)
                    label(value:e.claim) 
                }               
            }


        }
    }
}
