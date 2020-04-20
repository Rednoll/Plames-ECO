import { createMuiTheme, ThemeProvider } from '@material-ui/core/styles';

const mainTheme = createMuiTheme({
	
	palette: {

		primary: { main: "#B0D5F2" },
		error: { main: "#FF1E45" }
	}
});

export default mainTheme;