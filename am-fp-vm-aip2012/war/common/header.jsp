<!-- HEADER START -->
<div id="head">
	<div id="header">IMMAGINE HEAD</div>
	<div id="topmenu">
	<div id='jqxMenu' style='visibility: hidden; margin-left: 60px;'>
	<ul>
		<li><a href="/">Home</a></li>
		<li><a href="#">Progetti</a></li>
		<li><a href="#">Eventi Pubblici</a></li>
		<li>Partners
			<ul>
				<li><a href="#">Tutti i partners</a></li>
				<li><a href="#">Tutti i leader di progetto</a></li>
			</ul>		
		</li>
		<li><a href="#">Ricercatori</a></li>
		<li><a href="#">Attività</a></li>
		<li><a href="#">La Commissione Europea</a></li>
		<li><a href="#">Regole d'iscrizione</a></li>
		<li><a href="#">Crea un progetto</a></li>
	</ul>
	</div>
	</div>
</div>
<script type="text/javascript">
            $(document).ready(function () {
                // Create a jqxMenu
                $("#jqxMenu").jqxMenu({ width: '600', height: '30px', theme: 'base' });
                $("#jqxMenu").css('visibility', 'visible');
                $("#jqxMenu").jqxMenu('disable', 'fin', true);
            });
        </script>
<!-- HEADER END -->