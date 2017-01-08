const React = require('react-native');

const { StyleSheet } = React;

module.exports = StyleSheet.create({
  container: {
    flex: 1,
    height: 100,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    borderColor: '#e2e2e2',
    borderStyle: 'solid',
    borderWidth: 0.5,
  },
  ic_categories: {
    fontSize: 30,
    color: '#2c9edf',
    marginBottom: 5
  }
});
