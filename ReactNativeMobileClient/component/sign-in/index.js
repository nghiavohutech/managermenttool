import React, {Component} from 'react';
import {View, TouchableOpacity} from 'react-native';
import { Container, InputGroup, Input, Header, Title, Text, Content, Footer, FooterTab, Button, Icon } from 'native-base';
import VIcon from 'react-native-vector-icons/FontAwesome';
import styles from './styles';
export default class SignInPaper extends Component {
  render() {
         return (
           <View style = {styles.container}>
             <InputGroup borderType='regular' style={styles.input}>
                 <Icon name='ios-person' style={styles.ic_left_input}/>
                 <Input placeholder='Tên đăng nhập'/>
             </InputGroup>
             <InputGroup borderType='regular' style={styles.input}>
                 <Icon name='ios-unlock' style={styles.ic_left_input}/>
                 <Input placeholder='Mật khẩu' secureTextEntry/>
             </InputGroup>
             <View style={styles.row_sign_in_container}>
               <TouchableOpacity>
                 <Text style={styles.txt_forget_pass}>
                   Quên mật khẩu?
                 </Text>
               </TouchableOpacity>
               <Button primary iconRight style={styles.btn_sign_in}>
                   Đăng nhập
                   <Icon name='ios-arrow-forward' />
               </Button>
             </View>
             <View style={styles.row_sign_up_container}>
               <Text>
                 Chưa có tài khoản?
               </Text>
               <TouchableOpacity>
                 <Text style={styles.txt_sign_up}>
                   Đăng ký mới
                 </Text>
               </TouchableOpacity>
             </View>
             <VIcon.Button name = 'facebook' style={styles.btn_sign_in_fb}>
               Đăng nhập bằng Facebook
             </VIcon.Button>
             <VIcon.Button name = 'google' style={styles.btn_sign_in_gg}>
               Đăng nhập bằng Google+
             </VIcon.Button>
           </View>
         );
     }
 }
