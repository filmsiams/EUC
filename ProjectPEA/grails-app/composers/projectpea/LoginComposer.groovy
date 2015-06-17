package projectpea
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

class LoginComposer extends zk.grails.Composer {

    def afterCompose = { window ->

        $('#user').focus()
        Date date = new Date()      
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat() 
        df.applyPattern("dd/MM/yyyy")
        java.text.SimpleDateFormat tf = new java.text.SimpleDateFormat()        
        tf.applyPattern("HH:mm:ss")


    	$('#login').on('click',{
    		def check = Employee.findByEmid($('#user').text())
    		if(check != null){
    			if(check.emid == $('#user').text() && check.passwords == $('#pass').text()){
    				session.user = check.emid
    				session.claim = check.claim                    
                    session.editin = "in"
                    
                    check.editin = "in"
                    check.save()

                    def loginsave = new Logincheck()
                    loginsave.user = session.user
                    loginsave.claim = session.claim
                    loginsave.timelogin = tf.format(date)
                    loginsave.save()

                    def login = new Logindata()
                    login.user = session.user
                    login.claim = session.claim
                    login.timelogin = tf.format(date)
                    login.timelogout = ""
                    login.date = df.format(date)

                    login.ckin = "in"
                    session.ckin = login.ckin
                                        
                    login.save()
                    
                    redirect(uri: "/index.zul")

    			}
    			else{
    				$('#status').val("รหัสผ่านไม่ถูกต้องค่ะ")
    			}
    		}else{
    			if($('#user').text() == "admin" && $('#pass').text() == "admin"){
    				session.user = "admin"
	    			session.claim = "Admin"

                    def loginsave = new Logincheck()
                    loginsave.user = session.user
                    loginsave.claim = session.claim
                    loginsave.timelogin = tf.format(date)
                    loginsave.save()

                    def login = new Logindata()
                    login.user = session.user
                    login.claim = session.claim
                    login.timelogin = tf.format(date)
                    login.timelogout = ""
                    login.date = df.format(date)

                    login.ckin = "in"
                    session.ckin = login.ckin
                                        
                    login.save()
                    
                    redirect(uri: "/index.zul")	    				    			
	    			
    			}
                else{
                    $('#status').val("ไม่พบผู้ใช้ : "+$('#user').text()+" ค่ะ")
                    $('#user').val("")
                    $('#pass').val("")
                }
    		}
    	})
        
    }
}