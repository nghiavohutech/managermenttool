/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
  AppRegistry,
  StyleSheet,
  TouchableOpacity
} from 'react-native';
import { Container, Header, Title, Text, Content, Footer, FooterTab, Button, Icon } from 'native-base';
import theme from './theme/light'
import ToolPaper from './component/tool/index'
import SignInPaper from './component/sign-in/index'
class ReactNativeMobileClient extends Component {
  constructor(props){
    super(props);
    this.state = {
      viewPaper: <ToolPaper />,
      activeTabTool: true,
      activeTabMe: false
    }
  }
  activeTabTool() {
    this.setState({
    activeTabTool: true,
    activeTabMe: false
    });
  }
  activeTabMe() {
    this.setState({
    activeTabTool: false,
    activeTabMe: true
    });
  }
 render() {
   return (
          <Container theme={theme}>
            <Header>
              <Title>Management Tool</Title>
            </Header>
          <Content>
              {this.state.viewPaper}
          </Content>
            <Footer>
              <FooterTab>
                <Button active = {this.state.activeTabTool} onPress={()=>{this.setState({viewPaper: <ToolPaper />});
                this.activeTabTool()}}>
                  Tools
                  <Icon name="ios-home"></Icon>
                </Button>
                <Button active = {this.state.activeTabMe} onPress={()=>{this.setState({viewPaper: <SignInPaper />});
                this.activeTabMe()}}>
                  Cá nhân
                  <Icon name="ios-person"></Icon>
                </Button>
              </FooterTab>
            </Footer>
          </Container>
        );
    }
}

AppRegistry.registerComponent('ReactNativeMobileClient', () => ReactNativeMobileClient);
