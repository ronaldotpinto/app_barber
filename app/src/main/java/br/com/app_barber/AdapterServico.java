package br.com.app_barber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterServico extends BaseAdapter {

    private Context context;
    private List<Servico> lista;
    private LayoutInflater inflater;

    public AdapterServico(Context context, List<Servico> lista){
        this.context = context;
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if( convertView == null ){
            convertView = inflater.inflate
                    (R.layout.layout_lista_servicos, null);
            item = new Suporte();
           // item.tvCodigo = (TextView)
                  //  convertView.findViewById(R.id.tvListaCodigo);
            item.tvServico = (TextView)
                    convertView.findViewById(R.id.tvListaServico);
            item.tvValor = (TextView)
                    convertView.findViewById(R.id.tvListaValor);

            convertView.setTag(item);
        }else {
            item = (Suporte) convertView.getTag();
        }

        Servico servico = lista.get( position );
        //item.tvCodigo.setText(  servico.getId());
        item.tvServico.setText(  servico.getServico() );
        item.tvValor.setText(  servico.getValor()  );



        return convertView;
    }

    private class Suporte{
        TextView tvCodigo, tvServico, tvValor;
    }

}










